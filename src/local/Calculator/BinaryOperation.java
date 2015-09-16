package local.Calculator;

public interface BinaryOperation extends UnaryOperation {
	void setOperandB(double operandB);
	void setOperands(double operandA, double operandB);
	String getOperandBName(String operandBName);
}
