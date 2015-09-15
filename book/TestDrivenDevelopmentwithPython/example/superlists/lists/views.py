from django.shortcuts import redirect, render
from django.http import HttpResponse
from lists.models import Item
from lists.models import List

# Create your views here.
# home_page = None
def home_page(request):
#    return HttpResponse(b'<html><title>To-Do lists</title></html>')
    """
    if request.method == 'POST':
        return HttpResponse(request.POST['item_text'])
    return render(request, 'home.html');
    """
    # item = Item()
    # item.text = request.POST.get('item_text', '')    
    # item.save()

    # if request.method == 'POST':
    #     Item.objects.create(text=request.POST['item_text'])
    #     return redirect('/lists/the-only-list-in-the-world/')
    # else:
    #     new_item_text = ''
    # items = Item.objects.all()

    # return render(request, 'home.html', {
    #     'new_item_text': request.POST.get('item_text', ''), 
    # })
    return render(request, 'home.html')

def view_list(request, list_id):
    list_ = List.objects.get(id=list_id)
    # items = Item.objects.filter(list=list_)
    return render(request, 'list.html', {'list': list_})

def add_item(request, list_id):
    list_ = List.objects.get(id=list_id)
    Item.objects.create(text=request.POST['item_text'], list=list_)
    return redirect('/lists/%d/' % (list_.id))

def new_list(request):
    list_ = List.objects.create()
    Item.objects.create(text=request.POST['item_text'], list=list_)
    return redirect('/lists/%d/' % (list_.id))

