package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.CompoentScanConfig;
import se.lexicon.data_acess.StudentDao;
import se.lexicon.util.UserInputService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(CompoentScanConfig.class);
StudentDao studentDao= context.getBean(StudentDao.class);
UserInputService userInputService = context.getBean(UserInputService.class);


}
}


