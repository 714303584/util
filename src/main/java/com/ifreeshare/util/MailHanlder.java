package com.ifreeshare.util;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Mail senter
 * 
 * 	
		Document doc = Jsoup.parse(message.getContent());
		
		Elements imgs =  doc.select("img");
		String userDir = BaseController.webAppRoot.substring(0, BaseController.webAppRoot.length() - 1);
		
		
		
		Map<String, String> images = new HashMap<String, String>();
		Iterator<Element> it = imgs.iterator();
		while (it.hasNext()) {
		 	Element img = it.next();
		 	
		 	String srcValue = img.attr("src");
		 	
		 	if (srcValue.startsWith("/ueditor/jsp/upload/image/")) {
		 		
					UUID imageUuid = UUID.randomUUID();
					String imageUuidV = imageUuid.toString();
					img.attr("src",  "cid:" + imageUuidV);
					images.put(imageUuidV, userDir+srcValue);
				}
		}
		
		System.out.println(doc.html());
		message.setContent(doc.html());
		
		List<String> recipients = new ArrayList<String>();
		recipients.add("714303584@qq.com");
		message.setImages(images);
		message.setSender("zss19920514@sina.com");
		message.setRecipients(recipients);
		
		MailHanlder hanlder = new MailHanlder(BaseDataCacheUtil.mailProperties);
		hanlder.setMailMessage(message);
		hanlder.sendMessage();
		
 * 
 * 
 * 
 * @author zhuss
 */
public class MailHanlder {

	//The address of the mail server
	public static final String MAIL_HOST = "mail.host";
	//The port of the mail server
	public static final String MAIL_TRANSPORT_PROTOCOL = "mail.transport.protocol";
	//
	public static final String MAIL_SMTP_AUTH = "mail.smtp.auth";

	//Mail users
	public static final String MAIL_USER = "subscriber.mail.user";
	// the password of Mail user
	public static final String MAIL_PASSWORD = "subscriber.mail.password";

	//Sends a message using a session
	private Session session;

	private MailMessage mailMessage;
	//The profile to use for sending mail
	private Properties config;

	public MailHanlder(Properties config) {
		try {
			this.config = config;
			Properties prop = new Properties();
			prop.setProperty(MAIL_HOST,
					config.getProperty("subscriber.mail.stmp"));
			prop.setProperty(MAIL_TRANSPORT_PROTOCOL, "smtp");
			prop.setProperty(MAIL_SMTP_AUTH, "true");
			session = Session.getInstance(prop);
			session.setDebug(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MailMessage getMailMessage() {
		return mailMessage;
	}

	public void setMailMessage(MailMessage mailMessage) {
		this.mailMessage = mailMessage;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	
	/**
	 * Creates a mail object
	 * @return 
	 */
	public MimeMessage createMixMail() {

		MimeMessage message = new MimeMessage(session);
		try {

			message.setSubject(mailMessage.getTitle());
			message.setFrom(mailMessage.getSender());

			// new Address[] {
			// // 参数1：邮箱地址，参数2：姓名（在客户端收件只显示姓名，而不显示邮件地址），参数3：姓名中文字符串编码
			// // new InternetAddress(recipient, "utf-8"),
			// }

			List<Address> toAddrss = mailMessage.getRecipientsAddress();
			Address[] to = new Address[toAddrss.size()];
			toAddrss.toArray(to);
			// Set the sender of the message
			message.setRecipients(RecipientType.TO, to);
			
			//The body of the mail message
			MimeBodyPart mbp = new MimeBodyPart();
			//The referenced resource of the mail message
			MimeMultipart mmp = new MimeMultipart("related");

			//Sets the encoding format for mail messages
			mbp.setContent(mailMessage.getContent(), "text/html;charset=UTF-8");
			
			//The picture of the mail message
			Map<String, String> images = mailMessage.getImages();
			Iterator<String> it = images.keySet().iterator();
			mmp.addBodyPart(mbp);
			while (it.hasNext()) {

				String key = it.next();
				String value = images.get(key);
				MimeBodyPart imagePart = new MimeBodyPart();
				DataSource ds = new FileDataSource(new File(value));
				DataHandler dh = new DataHandler(ds);
				imagePart.setDataHandler(dh);
				imagePart.setContentID(key);
				mmp.addBodyPart(imagePart);
			}

			message.setContent(mmp);
			message.saveChanges();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return message;
	}

	/**
	 * send email
	 */
	public void sendMessage() {
		try {
			Transport ts = session.getTransport();
			ts.connect(config.getProperty(MAIL_HOST),
					config.getProperty(MAIL_USER),
					config.getProperty(MAIL_PASSWORD));
			Message message = createMixMail();
			ts.sendMessage(message, message.getAllRecipients());
			ts.close();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
