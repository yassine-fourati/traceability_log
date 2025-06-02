package traceability_log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TraceabilityLogService {

    private static final Logger logger = LogManager.getLogger(TraceabilityLogService.class);
    private static final String BASE_PACKAGE = "traceability_log"; // <-- change if your base package is different

    public void writeLogException(String userId, Exception e, Object... params) {
        try {
            // Build parameter info
            StringBuilder paramsInfo = new StringBuilder();
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    paramsInfo.append("param").append(i + 1).append(": ")
                              .append(params[i] != null ? params[i].toString() : "null")
                              .append("; ");
                }
            } else {
                paramsInfo.append("No parameters.");
            }

            // Filter stack trace to only include your own classes
            StackTraceElement[] fullTrace = e.getStackTrace();
            StackTraceElement relevantTrace = null;
            for (StackTraceElement element : fullTrace) {
                if (element.getClassName().startsWith(BASE_PACKAGE)) {
                    relevantTrace = element;
                    break;
                }
            }

            String className = relevantTrace != null ? relevantTrace.getClassName() : "UnknownClass";
            String methodName = relevantTrace != null ? relevantTrace.getMethodName() : "UnknownMethod";
            int lineNumber = relevantTrace != null ? relevantTrace.getLineNumber() : -1;

            // Only log your application's relevant context and a cleaned message
            logger.error(String.format(
                "User: %s - Exception in %s.%s() at line %d with parameters [%s] - Message: %s",
                userId, className, methodName, lineNumber, paramsInfo, e.getMessage()
            ));

        } catch (Exception ex) {
            logger.error("Error while logging exception! Cause: {}", ex.getMessage(), ex);
        }
    }
}
