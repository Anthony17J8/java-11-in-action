import com.forward.service.GreeterService;
import com.forward.service.internal.FrenchGreetService;
import com.forward.service.internal.GermanGreetService;

module com.forward.greetsvc {

    exports com.forward.service;

    provides GreeterService with
            FrenchGreetService,
            GermanGreetService;
}