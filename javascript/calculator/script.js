function calculate(operation) {
    const num1 = parseFloat(document.getElementById("num1").value);
    const num2 = parseFloat(document.getElementById("num2").value);

    if (isNaN(num1) || isNaN(num2)) {
        alert("Enter a Valid Number");
        return;
    }

    let result = 0;
    switch (operation) {
        case "add":
            result = num1 + num2;
            break;
        case "subtract":
            result = num1 - num2;
            break;
        case "multiply":
            result = num1 * num2;
            break;
        case "divide":
            if (num2 === 0) {
                document.getElementById("result").textContent = "Result: Cannot divide by zero";
                return;
            } else {
                result = num1 / num2;
            }
            break;
        default:
            document.getElementById("result").textContent = "Result: Invalid operation";
            return;
    }

    document.getElementById("result").textContent = `Result: ${result}`;
}

document.getElementById("add").addEventListener("click", () => calculate("add"));
document.getElementById("subtract").addEventListener("click", () => calculate("subtract"));
document.getElementById("multiply").addEventListener("click", () => calculate("multiply"));
document.getElementById("divide").addEventListener("click", () => calculate("divide"));