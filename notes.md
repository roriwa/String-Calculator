```java
class x{
    private String solveFunctions(String equation) {
        for (String functionName : this.functions.keySet()) {
            String bracketsPattern = "()";
            Pattern pattern = Pattern.compile(Pattern.quote(functionName) + "\\(" + bracketsPattern + "\\)");
            Matcher matcher = pattern.matcher(equation);
            equation = matcher.replaceAll((MatchResult matchResult) -> {
                String content = matchResult.group(1);
                double value = this.solve(content);
                double result = this.functions.get(functionName).apply(value);
                return Double.toString(result);
            });
        }

        return equation;
    }
}
```
