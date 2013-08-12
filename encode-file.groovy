import org.mozilla.universalchardet.UniversalDetector;

    def dir = new File('C:\\temp');
    String fileName = "";
     
    dir.traverse {
            
        if (it.isFile() && (it.name =~ /xsd$/)) {
        
            def f=new File(it.canonicalPath).getText()
            new File(it.canonicalPath).write(f,'utf-8')
            
            println it.name
        }
    }
        
