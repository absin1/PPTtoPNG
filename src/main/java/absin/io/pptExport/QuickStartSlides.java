package absin.io.pptExport;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.slides.v1.SlidesScopes;
import com.google.api.services.slides.v1.Slides.Presentations;
import com.google.api.services.slides.v1.Slides.Presentations.Pages;
import com.google.api.services.slides.v1.Slides.Presentations.Pages.Get;
import com.google.api.services.slides.v1.Slides.Presentations.Pages.GetThumbnail;
import com.google.api.services.slides.v1.model.*;
import com.google.api.services.slides.v1.Slides;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class QuickStartSlides {
	/** Application name. */
	private static final String APPLICATION_NAME = "Google Slides API Java Quickstart";

	/** Directory to store user credentials for this application. */
	private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"),
			".credentials/slides.googleapis.com-java-quickstart");

	/** Global instance of the {@link FileDataStoreFactory}. */
	private static FileDataStoreFactory DATA_STORE_FACTORY;

	/** Global instance of the JSON factory. */
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

	/** Global instance of the HTTP transport. */
	private static HttpTransport HTTP_TRANSPORT;

	/**
	 * Global instance of the scopes required by this quickstart.
	 *
	 * If modifying these scopes, delete your previously saved credentials at
	 * ~/.credentials/slides.googleapis.com-java-quickstart
	 */
	private static final List<String> SCOPES = Arrays.asList(SlidesScopes.PRESENTATIONS_READONLY);

	static {
		try {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
		} catch (Throwable t) {
			t.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Creates an authorized Credential object.
	 * 
	 * @return an authorized Credential object.
	 * @throws IOException
	 */
	public static Credential authorize() throws IOException {
		// Load client secrets.
		InputStream in = Quickstart.class.getResourceAsStream("/client_secret.json");
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
				clientSecrets, SCOPES).setDataStoreFactory(DATA_STORE_FACTORY).setAccessType("offline").build();
		Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
		System.out.println("Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
		return credential;
	}

	/**
	 * Build and return an authorized Slides API client service.
	 * 
	 * @return an authorized Slides API client service
	 * @throws IOException
	 */
	public static Slides getSlidesService() throws IOException {
		Credential credential = authorize();
		return new Slides.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).setApplicationName(APPLICATION_NAME)
				.build();
	}

	public static void main(String[] args) throws IOException {
		// Build a new authorized API client service.
		Slides service = getSlidesService();

		// Prints the number of slides and elements in a sample presentation:
		// https://docs.google.com/presentation/d/1EAYk18WDjIG-zp_0vLm3CsfQh_i8eXc67Jo2O9C6Vuc/edit
		String presentationId = "1e5eCPJP94FdJB_vl0hQItTPR8UMDnAk3";
		Presentation response = service.presentations().get(presentationId).execute();
		List<Page> slides = response.getSlides();
		System.out.printf("The presentation contains %s slides:\n", slides.size());
		for (int i = 0; i < slides.size(); i++) {
			Page slide = slides.get(i);
			GetThumbnail getThumbnail = service.presentations().pages().getThumbnail(presentationId,
					slide.getObjectId()).setThumbnailPropertiesThumbnailSize("LARGE");
			Thumbnail thumbnail = getThumbnail.execute();
			System.out.println(thumbnail.getContentUrl());
			saveImage(thumbnail.getContentUrl(), "C:\\Users\\absin\\Downloads\\Session2\\" + i + "_desktop.png");
			System.out.printf("- Slide #%s contains %s elements.\n", i + 1, slide.getPageElements().size());
		}
	}

	public static void saveImage(String URL, String path) throws IOException {
		URL url = new URL(URL);
		InputStream in = new BufferedInputStream(url.openStream());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		int n = 0;
		while (-1 != (n = in.read(buf))) {
			out.write(buf, 0, n);
		}
		out.close();
		in.close();
		byte[] response = out.toByteArray();
		FileOutputStream fos = new FileOutputStream(path);
		fos.write(response);
		fos.close();
	}

}
