
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author metho
 */
public class OAuthSetup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws TwitterException, IOException {
        
        ConfigurationBuilder builder = new ConfigurationBuilder();
            builder.setDebugEnabled(true)
                .setOAuthConsumerKey(null)
                .setOAuthConsumerSecret(null);
            
        Twitter twitter = new TwitterFactory().getInstance();
        
        twitter.setOAuthConsumer("Z8SbCcdgdNLJDeNXh8GH7kCbd", "VNtCpvtbwDymTykWk66xSM6XZ457aA1rB0IAx1B2mq5S7I2bBR");
        RequestToken requestToken = twitter.getOAuthRequestToken();
        AccessToken accessToken = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(null == accessToken){
            System.out.println("Abrir url para acessar a conta:");
            System.out.println(requestToken.getAuthorizationURL());
            System.out.println("Digite o pin:");
            String pin = br.readLine();
            try{
                if(pin.length() > 0){
                    accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                }else{
                    accessToken = twitter.getOAuthAccessToken();
                }
            }catch (TwitterException te){
                        if(401 == te.getStatusCode()){
                            System.out.println("Token de acesso desabilitado.");
                        }else{
                            te.printStackTrace();
                        }
            }
        }
        
        System.out.println(twitter.verifyCredentials().getId());
        System.out.println("token : " + accessToken.getToken());
        System.out.println("tokenSecret : " + accessToken.getTokenSecret());
        Status status = twitter.updateStatus(args[0]);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
        System.exit(0);
    }
    
    
}
