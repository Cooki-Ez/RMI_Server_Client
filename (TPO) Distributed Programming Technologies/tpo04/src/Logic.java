import java.math.BigDecimal;
import java.util.regex.Pattern;



public class Logic {



    private static final String LEGAL_NUMBER_REGEX = "(0|-?[1-9]\\d*)(\\.\\d+)?";
    private static final Pattern PATTERN_FOR_NUMBER = Pattern.compile(LEGAL_NUMBER_REGEX);

    public static Model processParameters(String component_1, String component_2) {


        if (component_1 == null || component_2 == null) {
            return new Model(ResponseType.MISSING_PARAMETER);
        }

        if((component_1 = component_1.trim()).isEmpty() || (component_2 = component_2.trim()).isEmpty()) {
            return new Model(ResponseType.MISSING_PARAMETER);
        }

        if (!PATTERN_FOR_NUMBER.matcher(component_1).matches() || !PATTERN_FOR_NUMBER.matcher(component_2).matches()) {
            return new Model(ResponseType.NAN_PARAMETER);
        }


        Model resultModel = new Model(ResponseType.OK);
        resultModel.setResult(new BigDecimal(component_1).add(new BigDecimal(component_2)));
        return resultModel;
    }

}
