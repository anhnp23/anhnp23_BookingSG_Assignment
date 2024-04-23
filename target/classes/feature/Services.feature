@BookingSG

Feature: BookingSG website's services working flow

  Scenario Outline: Service 1
    Given User opens browser and navigate "<service>" with "<url>" and click on Mock Login
    When User should see Booking page chooses the time slot
    And User clicks confirm button in Booking page
    And User should see Personal details page and click on Next button
    And User should see Review page and click on Submit button
    And User should see Booking request page in "<service>"
    Then User should see Your bookings page
    And User should see information of booking request in "<service>" with status as "<status>"

    Examples:
      | service   | url                                                                 | status             |
      | Service_1 | https://www.tst.bookingsg.io/public/services/wVkrnkOY/availability? | Pending Approval   |
      | Service_2 | https://www.tst.bookingsg.io/public/services/XDA7Dp4W/availability? | Pending Acceptance |
      | Service_3 | https://www.tst.bookingsg.io/public/services/nZklxkbP/availability? | Accepted           |
      | Service_4 | https://www.tst.bookingsg.io/public/services/8Ly07k0X/availability? | Pending Approval   |
      | Service_5 | https://www.tst.bookingsg.io/public/services/jgpElAn1/availability? | Accepted           |
      | Service_6 | https://www.tst.bookingsg.io/public/services/J2p42yWe/availability? | Pending Acceptance |
