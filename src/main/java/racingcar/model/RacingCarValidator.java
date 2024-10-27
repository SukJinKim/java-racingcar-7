package racingcar.model;

import java.util.HashSet;
import java.util.List;

public class RacingCarValidator {
    private static final String INVALID_CAR_NAME_ERROR_MESSAGE = "부적절한 형식의 자동차 이름을 입력했습니다. (자동차 이름은 공백이 아닌 5자 이하 문자열)";
    private static final String DUPLICATED_CAR_NAME_ERROR_MESSAGE = "중복된 자동차 이름을 입력했습니다.";
    private static final int NAME_LENGTH_LIMIT = 5;

    public static void validate(String name) {
        if (name == null || name.isBlank() || isLongerThanLimit(name)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_ERROR_MESSAGE);
        }
    }

    public static void validate(List<RacingCar> list) {
        if (!list.stream().allMatch(new HashSet<>()::add)) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAME_ERROR_MESSAGE);
        }
    }

    private static boolean isLongerThanLimit(String name) {
        return name.length() > NAME_LENGTH_LIMIT;
    }
}
