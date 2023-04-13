import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    int num = 0;

    public String handleRequest(URI url) {
        List<String> myList = new ArrayList<>();
        List<String> myList2 = new ArrayList<>();
        if (url.getPath().equals("/add")) {
            String element = url.getPath().substring(url.getPath().indexOf("="));
            myList.add(element);
            return myList.toString();
        } 
        else{
            for (String e:myList){
                if(e.contains(url.getPath().substring(url.getPath().indexOf("=")))){
                    myList.add(e);
                }
            }
            return myList2.toString();
        }
        
    }
}

class NumberServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}