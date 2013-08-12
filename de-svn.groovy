import java.io.File;

String path = "C:\\temp";
// Create a ref for closure
def checkSVN
def delAll


delAll = { println "Dir ${it.canonicalPath}";
            it.eachDir( delAll );
            it.eachFile {
                println "File ${it.canonicalPath}";
                it.delete()
            }
    }

// Define closure
checkSVN = {
            it.eachDir( checkSVN );
            it.eachFileMatch( ~".svn" ) { f ->
                 delAll(f)
                f.delete()
            }
    }




// Apply closure
checkSVN( new File(path) )
