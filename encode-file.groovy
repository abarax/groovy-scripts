
import org.mozilla.universalchardet.UniversalDetector;

    def dir = new File('C:\\SOA\\design\\wsc\\src\\main\\resources\\service\\partner\\common');
    String fileName = "";
     
    dir.traverse {
            
        if (it.isFile() && (it.name =~ /xsd$/)) {
        
            def f=new File(it.canonicalPath).getText()
            new File(it.canonicalPath).write(f,'utf-8')
            
            println it.name
        }
    }
        