/*class Kalk
{
  public static void main(String[] args) {

  }
}

static class InvalidFormatException extends DateParseException {

  InvalidFormatException(String input, Throwable thr) {
    super("Invalid date format: " + input, thr);
  }
}

static class DateOutOfRangeException extends DateParseException {

  DateOutOfRangeException(String date) {
    super("Date out of range: " + date);
  }

}

class DateParseException extends RuntimeException {

  DateParseException(String input) {
    super(input);
  }

  DateParseException(String input, Throwable thr) {
    super(input, thr);
  }
}

static class AgeCalculator {

  private static LocalDate parseDate(String birthDateAsString) {
    LocalDate birthDate;
    try {
      birthDate = LocalDate.parse(birthDateAsString);
    } catch (DateTimeParseException ex) {
      throw new InvalidFormatException(birthDateAsString, ex);
    }

    if (birthDate.isAfter(LocalDate.now())) {
      throw new DateOutOfRangeException(birthDateAsString);
    }

    return birthDate;
  }
}

  public static int calculateAge(String birthDate) {
    if (birthDate == null || birthDate.isEmpty()) {
      throw new IllegalArgumentException();
    }

    try {
      return Period
              .between(parseDate(birthDate), LocalDate.now())
              .getYears();
    } catch (DateParseException ex) {
      throw new CalculationException(ex);
    }
  }



class MyResource implements AutoCloseable {
  public void close() {
    System.out.println("close");
  }
}

interface AutoCloseable {
  void close() throws Exception;
}

  */