package pro.sky.exever.calculator;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
	private final CalculatorService calculatorService;

	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	@GetMapping
	public String hello() {
		return "Добро пожаловать в калькулятор";
	}

	@GetMapping("/{methodName}")
	public String calculate(@PathVariable String methodName, @RequestParam Map<String, String> params) {
		if (params.containsKey("num1") && params.containsKey("num2")) {
			try {
				double num1 = Double.parseDouble(params.get("num1"));
				double num2 = Double.parseDouble(params.get("num2"));
				return "<h1>" + switch (methodName) {
				case "plus" -> params.get("num1")+" + "+ params.get("num2")+" = "+calculatorService.plus(num1, num2);
				case "minus" -> params.get("num1")+" - "+ params.get("num2")+" = "+calculatorService.minus(num1, num2);
				case "multiply" -> params.get("num1")+" * "+ params.get("num2")+" = "+calculatorService.multiply(num1, num2);
				case "divide" -> params.get("num1")+" / "+ params.get("num2")+" = "+calculatorService.divide(num1, num2);
				default ->
					"Неизвестный метод. Уточните метод (/plus|/minus|/multiply|/divide) и передайте два числа в параметрах ?num1=&num2=";
				} + "</h1>";
			} catch (NumberFormatException e) {
				return "<h1>Неудалось прочитать числа</h1>";
			}
		} else {
			return "<h1>Необходимо передать два числа: num1 и num2</h1>";
		}

	}
}
