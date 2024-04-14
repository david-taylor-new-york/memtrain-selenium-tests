#!/bin/bash

# Check if repeat_count argument is provided
if [ $# -ne 1 ]; then
    echo "Usage: $0 <repeat_count>"
    exit 1
fi

# Get the repeat_count argument
repeat_count=$1

# Create a log file
mvn_log_file="../../results_mvn.txt"
log_file="../../results_summary.txt"
echo "Test Iteration Results" > "$log_file"
echo "---------------------" >> "$log_file"

# Variable to track whether an error occurred
error_occurred=false

# Run the tests in a loop
for ((i=1; i<=$repeat_count; i++)); do
    echo "Running tests - Iteration $i"
    mvn test >> "$mvn_log_file"  # Append output to log file
    if [ $? -eq 0 ]; then
        echo "Iteration $i: PASSED" >> "$log_file"
    else
        echo "Iteration $i: FAILED" >> "$log_file"
        error_occurred=true
        break
    fi
done

if [ "$error_occurred" = true ]; then
    echo "Error occurred during tests. See $mvn_log_file for details."
else
    echo "All iterations passed successfully. See $mvn_log_file for details."
fi

