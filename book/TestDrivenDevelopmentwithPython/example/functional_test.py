from selenium import webdriver
import unittest

class NewVisitorTest(unittest.TestCase):
  
  def setUp(self):
    self.browser = webdriver.Firefox()
    self.browser.implicitly_wait(3)

  def tearDown(self):
    self.browser.quit()

  def test_can_start_a_list_and_retrieve_it_later(self):
    self.browser.get('http://localhost:8000')

    self.assertIn('To-Do', self.browser.title)
    header_text = self.browser.find_element_by_tag_name('h1').header_text
    self.assertEqual(
      inputbox.get_attribute('placeholder'),
      'insert work item'
    )
    inputbox.send_keys(Keys.ENTER)

    table = self.browser.find_element_by_id('id_list_table')
    rows = table.find_element_by_tag_name('tr')
    self.assertTrue(
      any(row.text == '1: buy bird' for row in rows)

    )

    self.fail('Finish the test!')


if __name__ == '__main__':
  unittest.main(warnings='ignore')

#if __name__ == '__main__':
#  unittest.main(warnings='ignore')

