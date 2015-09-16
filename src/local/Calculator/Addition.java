package local.Calculator;

public class Addition implements BinaryOperation {
	public static final String OPERAND_NAME = "addend";
	public static final String RESULT_NAME = "sum";
	public static final String DESCRIPTION = "Calculate the sum of 2 numbers.";
	
	private double addendA;
	private double addendB;
	private double sum;
	private boolean resultValid;
	
	// Default constructor, initialize to 0;
	public Addition()
	{
		setAddendA(0);
		setAddendB(0);
	}
	
	// Constructor with operands
	public Addition(double addendA, double addendB)
	{
		setAddendA(addendA);
		setAddendB(addendB);
	}
	
	// Perform calculation and store result (this will validate the result)
	public void calculateSum()
	{
		sum = getAddendA() + getAddendB();
		validateResult();
	}
	
	// Setters and getters
	public void setAddendA(double addend)
	{
		if (getAddendA() != addend)
		{
			addendA = addend;
			invalidateResult();
		}
	}
	
	public double getAddendA()
	{
		return this.addendA;
	}
	
	public void setAddendB(double addend)
	{
		if (getAddendB() != addend)
		{
			addendB = addend;
			invalidateResult();
		}
	}
	
	public double getAddendB()
	{
		return this.addendB;
	}
	
	public boolean isResultValid()
	{
		return resultValid;
	}
	
	public double getSum()
	{
		// If result is marked as invalid, re-calculate the sum, otherwise return
		// the existing value
		if (!isResultValid())
		{
			calculateSum();
			
			if (!isResultValid())
			{
				throw new IllegalStateException("Sum Invalid");
			}
		}
		
		return sum;
	}
	
	// Mark result as valid
	private void validateResult()
	{
		setResultValid(true);
	}
	
	// Mark result as invalid
	private void invalidateResult()
	{
		setResultValid(false);
	}
	
	private void setResultValid(boolean resultValid)
	{
		this.resultValid = resultValid;
	}
	
	@Override
	public String toString()
	{
		String stringValue = getAddendA() + " + " + getAddendB();
		if (isResultValid())
		{
			stringValue += " = " + getSum();
		}
		
		return stringValue;
	}
	
	// Interface requirements
	@Override
	public void setOperand(double operand) {
		setAddendA(operand);
	}

	@Override
	public void setOperandB(double operandB) {
		setAddendB(operandB);

	}
	
	@Override
	public double getResult() {
		return getSum();
	}
	
	@Override
	public void setOperands(double operandA, double operandB) {
		setAddendA(operandA);
		setAddendB(operandB);
	}

	@Override
	public String getOperandName(String operandName) {
		return Addition.OPERAND_NAME;
	}

	@Override
	public String getOperandBName(String operandBName) {
		return Addition.OPERAND_NAME;
	}

	@Override
	public String getResultName(String resultName) {
		return Addition.RESULT_NAME;
	}

	@Override
	public String getDescription(String desctiption) {
		return Addition.DESCRIPTION;
	}

}
