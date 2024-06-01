package pro.sky.exever.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
	@Override
	public Double plus(Double num1, Double num2) {
		return num1 + num2;
	}

	@Override
	public Double minus(Double num1, Double num2) {
		return num1 - num2;
	}

	@Override
	public Double multiply(Double num1, Double num2) {
		return num1 * num2;
	}

	@Override
	public Double divide(Double num1, Double num2) {
		if (num2 == 0) {
			return -1.0d;
		}
		return num1 / num2;
	}
}
