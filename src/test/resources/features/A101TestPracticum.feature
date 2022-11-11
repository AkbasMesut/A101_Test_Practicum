Feature: A101 Test Automation
  User story :
  Uçtan uca ödeme ekranına kadar test otomasyonu.

  @wip
  Scenario: User order a product without sign in

  Given user is on the a101 webpage and accept cookies
  When  user search "sock" product at the search box
  And   user select "Man" from catagories filters
  And   user select first product and assert it is for man
  And   user select size and add the product to cart
  And   user view and confirm the cart
  And   user click continue without sign in button
  And   user send mail address and click proceed button
  And   user click make a new address button
  And   user fill out address update page
  And   user click "Save and Proceed" button
  Then  user should see payment screen opened

