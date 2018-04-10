$(function(){
	
	switch(menu)
	{
	case 'About us':
		$('#about').addClass('active');
		break;
	case 'Contact us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	default:{
		$('#home').addClass('active');
	 	$('#a_'+menu).addClass('active');
		break;
	}
	}


/*var products=[
	
				['1','Samsung'],
				['2','Oppo'],
				['3','Moto']
];*/


var $table=$('#productListTable');

if($table.length)
	{
	var jsonUrl='';
	if(window.categoryId=='')
		{
		jsonUrl= window.contextRoot +'/json/data/all/products';
		
		}
	else
		{
		jsonUrl= window.contextRoot +'/json/data/category/'+window.categoryId+'/products';
		}
		
	$table.DataTable({
		lengthMenu:[[3,5,10,-1],['3 Records','5 Records','10 Records','ALL']],
		ajax:{
			url:jsonUrl,
			dataSrc:''
		},
		columns:[
			{
				data:'code',
				mRender:function(data,type,row)
				{
					return '<img src="'+window.contextRoot+'/resources/images/'+data+'.png" width="100px"/>';
				}
			},
			{
				data:'name'
			},
			{
				data:'brand'
			},
			{
				data:'unitPrice'
			},
			{
				data:'quantity',
					mRender:function(data,type,row)
					{
						if(data<1)
							{
							return '<span style="color:red">Out of stock</span>';
							}
						return data;
					}
			},
			{
				data:'id',
				bSortable:false,
				mRender:function(data,type,row)
				{
					var str='';
				
					str+='<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span>View</a> &#160;';
					
					if(row.quantity<1)
						{
						str+='<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon-shopping-cart"></span>Add to cart</a>';
						}
					else
						{
						str+='<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon-shopping-cart"></span>Add to cart</a>';
						}
					
					
					return str;
				}
			}
		]
	});
	}

var $alert=$('.alert');
if($alert.length)
	{
	setTimeout(function(){
		$alert.fadeOut('slow');
	},3000)
	}

});