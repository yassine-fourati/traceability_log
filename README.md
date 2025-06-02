# TraceabilityLog

## Overview

`TraceabilityLog` is a simple Java service designed to help you **log exceptions with detailed traceability**.  
It captures exception information, including the class, method, line number, and method parameters, to give you clear insight when errors occur.

---

## Features

- Logs exceptions with the originating class, method name, and line number.
- Supports variable number of parameters (`Object... params`) for detailed context.
- Uses Apache Log4j 2 for robust, configurable logging.
- Designed for easy integration into your Java applications.
- Keeps your logs clean by focusing on exceptions thrown **inside your code** (not from external libraries).

---

## Getting Started

### Prerequisites

- Java 8 or above
- Maven (for dependency management and build)

### Installation

Clone the repository:

```bash
git clone https://github.com/yassine-fourati/traceability_log.git
cd traceability_log
