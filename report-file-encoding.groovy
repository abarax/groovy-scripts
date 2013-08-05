
import org.mozilla.universalchardet.UniversalDetector;

    def dir = new File('C:\\code');
    String fileName = "";
     
    dir.traverse {
            
        if (it.isFile() && (it.name =~ /xsd$/)) {
            byte[] buf = new byte[4096];
            
            fileName = it.canonicalPath;
            
            java.io.FileInputStream fis = new java.io.FileInputStream(fileName);
        
            // (1)
            UniversalDetector detector = null;
            
            
            detector = new UniversalDetector(null);
        
            // (2)
            int nread;
            while ((nread = fis.read(buf)) > 0 && !detector.isDone()) {
              detector.handleData(buf, 0, nread);
            }
            // (3)
            detector.dataEnd();
        
            // (4)
            String encoding = detector.getDetectedCharset();
            if (encoding != null) {
         //     if (encoding != "UTF-8") {
                  System.out.println("Filename = " + it.name + ": Detected encoding = " + encoding);
            //  }
            } else {
                System.out.println("Filename = " + it.name + ":No encoding detected.");
            }
        
            // (5)
            detector.reset();
            
        }
    }
        