package knox.frontend.model;

import java.util.ArrayList;
import java.util.List;

public class DummyDataGrundfos {

    //Grundfos DummyData
    public String section; //Page title
    public List<String> subsections = new ArrayList<>();  //Page subtitle
    public List<String> subsectioncontent = new ArrayList<>();
    public List<String> images = new ArrayList<>(); //Images in article


    public DummyDataGrundfos() {/*
        this.section = section;
        this.subsections = subsections;
        this.subsectioncontent = subsectioncontent;
        this.images = images;*/

// a page in one of their pdf documents
        section = "4. Electrical connection";
        subsections.add("4.1 General");
        subsectioncontent.add("The electrical connection should be carried out by\n" +
                "an authorized electrician in accordance with local\n" +
                "regulations. The supply voltage, rated maximum current and\n" +
                "power factor (PF) appear on the motor nameplate.\n" +
                "The required voltage for Grundfos submersible MS 3\n" +
                "and MSE 3 motors, measured at the motor terminals,\n" +
                "is –10%/+6% of the nominal voltage during continuous operation (including variation in the supply voltage and losses in cables).\n" +
                "If the pump is connected to an installation where a\n" +
                "Ground Fault circuit breaker (GFI) is used as additional protection, this circuit breaker must trip out\n" +
                "when ground fault currents with DC content\n" +
                "(pulsating DC) occur");
        subsections.add("Supply voltage");
        subsectioncontent.add("1 x 100-115 V or 1 x 200-240 V, 50/60 Hz.\n" +
                "The current consumption can only be measured\n" +
                "accurately by means of a true RMS instrument.\n" +
                "If other instruments are used, the value measured\n" +
                "will differ from the actual value.\n" +
                "The SQE pumps can be connected to a CU 300 or\n" +
                "CU 301 control box. ");
        subsections.add("4.2 Motor protection");
        subsectioncontent.add("The motor has built-in automatic thermal overload\n" +
                "protection and requires no additional motor protection.");
        subsections.add("4.3 Connection of motor");
        subsectioncontent.add("The motor can be connected directly to the main\n" +
                "circuit breaker.\n" +
                "Start/stop of the pump will typically be done via a\n" +
                "pressure switch, see figs. 4 and 5.\n" +
                "Note: The pressure switch must be rated for the\n" +
                "maximum amps of the specific pump.");
        subsections.add("WARNING:");
        subsectioncontent.add("Before starting work on the pump, make\n" +
                "sure that the electricity supply has been\n" +
                "switched off and that it cannot be accidentally switched on.\n" +
                "This pump is permanent wiring connection\n" +
                "only.\n" +
                "Reduced risk of electric shock during\n" +
                "operation of this pump requires the provision of acceptable grounding.\n" +
                "The grounding connection must be made\n" +
                "by a copper conductor, at least the size of\n" +
                "the circuit conductors supplying the pump.\n" +
                "The pump must be connected to an external mains switch.\n" +
                "The pump must never be connected to a\n" +
                "capacitor or to another type of control box\n" +
                "than CU 300 or CU 301.\n" +
                "The pump must never be connected to an\n" +
                "external frequency converter.");
        subsections.add("WARNING:");
        subsectioncontent.add("Reduced risk of electric shock during\n" +
                "operation of this pump requires the provision of acceptable grounding. If the means\n" +
                "of connection to the supply connected box\n" +
                "is other than grounded metal conduit,\n" +
                "ground the pump back to the service by\n" +
                "connecting a copper conductor, at least\n" +
                "the size of the circuit conductors supplying\n" +
                "the pump.");

        images.add("C:\\Users\\Bro\\Desktop\\c#\\placeholder-pictures/grundfos1");
        images.add("C:\\Users\\Bro\\Desktop\\c#\\placeholder-pictures/grundfos2");

    }
}
