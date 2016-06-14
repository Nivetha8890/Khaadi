Feature: Khaadi Home Page
    AS A Khaadi User
    I WANT TO perform a search using Khaadi search
    SO THAT I can buy clothes easily
@regression @nivi
    Scenario: Khaadi Search
        Given I go to Khaadi home page
        When I see the Khaadi search
        And I type "handbag"
        Then I should see the handbags in search results
