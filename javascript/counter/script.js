let counterValue = 0;

document.getElementById("increment").addEventListener("click", function() {
  counterValue++;
  document.getElementById("counter-value").textContent = counterValue;
});

document.getElementById("decrement").addEventListener("click", function() {
  counterValue--;
  document.getElementById("counter-value").textContent = counterValue;
});