package john.lighterletter.com.galileo;

public class TestActivity {

    void someMethod() {

        //lambdas
        Listener listener = () -> {};
        listener.someListener();

        //implementation
        ParamListener in = System.out::print; // Print out the value passed in

        //call
        in.passed("Working lambdas");
    }

    //define
    interface Listener {
        void someListener();
    }

    //definition
    interface ParamListener {
        void passed(String s);
    }
}
