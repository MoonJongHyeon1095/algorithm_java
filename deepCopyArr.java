import java.lang.reflect.Array;

public class deepCopyArr {
    private static int[][] deepCopy(int[][] original){
        if (original == null) {
            return null;
        }

        int[][] result = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = new int[original[i].length];
            for (int j = 0; j < original[i].length; j++) {
                result[i][j] = original[i][j];
            }
        }
        return result;
    }

    //제네릭 타입이 컴파일 시점에만 존재하고 런타임에는 타입 정보가 사라지는 타입 소거(type erasure) 특성 때문에,
    // 런타임에는 제네릭 타입의 정확한 클래스 타입을 알 수 없습니다.
    public static <T> T[][] deepCopyWithGeneric(T[][] original) {
        if (original == null) {
            return null;
        }

        // 첫 번째 차원의 배열 생성
        T[][] result = (T[][]) Array.newInstance(original.getClass().getComponentType(), original.length);

        for (int i = 0; i < original.length; i++) {
            // 두 번째 차원의 배열을 적절한 컴포넌트 타입으로 생성
            result[i] = (T[]) Array.newInstance(original[i].getClass().getComponentType().getComponentType(), original[i].length);

            // 배열 내용을 for 루프를 사용해 직접 복사
            for (int j = 0; j < original[i].length; j++) {
                result[i][j] = original[i][j];
            }
        }

        return result;
    }
}
