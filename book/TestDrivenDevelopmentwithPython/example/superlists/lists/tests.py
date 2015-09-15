from django.core.urlresolvers import resolve
from django.http import HttpRequest
from django.test import TestCase
from lists.views import home_page
from django.template.loader import render_to_string


# Create your tests here.
class SmokeTest(TestCase):
 
    """   
    def test_bad_maths(self):
        self.assertEqual(1+1, 3)
    """
    def test_root_url_resolves_to_home_page_view(self):
        found = resolve('/')
        self.assertEqual(found.func, home_page)

    def test_home_page_returns_correct_html(self):
        request = HttpRequest()
        response = home_page(request)
        expected_html = render_to_string('home.html')
        # self.assertTrue(response.content.startswith(b'<html>'))
        # self.assertIn(b'<title>To-Do lists</title>', response.content)
        # self.assertTrue(response.content.strip().endswith(b'</html>'))
        self.assertEqual(response.content.decode(), expected_html)



    """
    def test_home_page_can_save_a_POST_request(self):
        request = HttpRequest()
        request.method = 'POST'
        request.POST['item_text'] = 'new work item'

        response = home_page(request)

        self.assertEqual(Item.objects.count(), 1)
        new_item = Item.objects.first()
        self.assertEqual(new_item.text, 'new work item')

        self.assertEqual(response.status_code, 302)
        # self.assertEqual(response['location'], '/')



        # self.assertIn('new work item', response.content.decode())
        # expected_html = render_to_string(
        #     'home.html',
        #     {'new_item_text': 'new work item'}
        # )
        # self.assertEqual(response.content.decode(), expected_html)
     """

    # def test_home_page_displays_all_list_items(self):
    #     Item.objects.create(text='itemey 1')
    #     Item.objects.create(text='itemey 2')

    #     request = HttpRequest()
    #     response = home_page(request)

    #     self.assertIn('itemey 1', response.content.decode())
    #     self.assertIn('itemey 2', response.content.decode())


from lists.models import Item

class ItemMOdelTest(TestCase):

    def test_saving_and_retrieving_items(self):
        first_item = Item()
        first_item.text = 'first item'
        first_item.save()
        second_item = Item()
        second_item.text = 'second item'
        second_item.save()

        saved_items = Item.objects.all()
        self.assertEqual(saved_items.count(), 2)

        first_saved_item = saved_items[0]
        second_saved_item = saved_items[1]
        self.assertEqual(first_saved_item.text, 'first item')
        self.assertEqual(second_saved_item.text, 'second item')

class ListViewTest(TestCase):

    def test_uses_list_template(self):
        response = self.client.get('/lists/the-only-list-in-the-world/')
        self.assertTemplateUsed(response, 'list.html')

    def test_home_page_displays_all_list_items(self):
        Item.objects.create(text='itemey 1')
        Item.objects.create(text='itemey 2')

        response = self.client.get('/lists/the-only-list-in-the-world/')


        self.assertIn('itemey 1', response.content.decode())
        self.assertIn('itemey 2', response.content.decode())

class NewListViewTest(TestCase):

    def test_saving_a_POST_request(self):
        self.client.post(
            '/lists/new',
            {'item_text': 'new work item'},
        )

        self.assertEqual(Item.objects.count(), 1)
        new_item = Item.objects.first()
        self.assertEqual(new_item.text, 'new work item')
        # request = HttpRequest()
        # request.method = 'POST'
        # request.POST['item_text'] = 'new work item'

        # response = home_page(request)

    def test_redirects_after_POST(self):
        # request = HttpRequest()
        # request.method = 'POST'
        # request.POST['item_text'] = 'new work item'

        # response = home_page(request)
        response = self.client.post(
            '/lists/new',
            {'item_text': 'new work item'},   
        )

        # self.assertEqual(response.status_code, 302)
        self.assertRedirects(response, '/lists/the-only-list-in-the-world/')
