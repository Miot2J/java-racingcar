package pobiRacingCar.utils;

public class StringUtils {
    
    public static boolean isNullOrBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
    //StringBuffer : 비동기 추천, StringBuilder : 저용량 메모리
    public static String repeat(String value, int repeatCount) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0 ; j < repeatCount ; j++) {
            sb.append(value);
        }
        return sb.toString();
    }
}