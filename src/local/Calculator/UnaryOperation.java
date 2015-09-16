package local.Calculator;

public interface UnaryOperation {

	void setOperand(double operand);
	String getOperandName(String operandName);
	String getResultName(String resultName);
	String getDescription(String desctiption);
	double getResult();
}
