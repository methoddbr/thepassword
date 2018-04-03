
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;



public class TwitterTeste {

    
  public static void main (String[] args){
      
      ConfigurationBuilder builder = new ConfigurationBuilder();
            builder.setDebugEnabled(true)
                .setOAuthConsumerKey("Z8SbCcdgdNLJDeNXh8GH7kCbd")
                .setOAuthConsumerSecret("VNtCpvtbwDymTykWk66xSM6XZ457aA1rB0IAx1B2mq5S7I2bBR")
                .setOAuthAccessToken("41016288-ntpNg61WPtpSVlEw1pAqhleYGFsChVbqDxELSiLG6")
                .setOAuthAccessTokenSecret("fjsEsTkw5LYPTFOIcUFX9ftWzq2bna0QB2DMxm1SmPrTj");
            

   TwitterFactory tf = new TwitterFactory(builder.build());
   Twitter tt = tf.getInstance();
   
      try {
          tt.updateStatus("testando");
      } catch (TwitterException e) {
      }
    }

}