package FactoryDesign;

public class SenderFactory {
	
	public static Sender createMailSender(){
		return new MailSender();
	}
	
	public static Sender createSmsSender(){
		return new SmsSender();
	}
	
	public static void main(String[] args){
		Sender sender = SenderFactory.createMailSender();
		sender.send();
	}
}
