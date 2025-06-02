package traceability_log;

public class RunApp {

	public static void main(String[] args) {
        TraceabilityLogService logService = new TraceabilityLogService();

        try {
            // Simulate a method that throws an exception
            simulateError("testUser", 123, "sampleParam");
        } catch (Exception e) {
            // Log the exception with userId, method name and parameters
            logService.writeLogException("testUser", e, "simulateError", 123, "sampleParam");
        }
    }

    public static void simulateError(String userId, int id, String input) {
        // Intentionally throw an exception
        throw new RuntimeException("Something went wrong in simulateError");
    }

}
