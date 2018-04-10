
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="container">


	<div class="row">
	<c:if test="${not empty message}">
	<div class="col-xs-12">
	<div class="alert alert-success alert-dismissible">
	<button type="button" class="close" data-dismiss="alert">&times;</button>
	${message}
	</div>
	</div>
	</c:if>

		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Product management</h4>

				</div>
				<div class="panel-body">

					<sf:form class="form-horizontal" modelAttribute="product" action="${contextRoot}/manage/products" method="POST" enctype="multipart/form-data">

						<div class="form-group">

							<label class="control-label col-md-4" for="name">Enter
								product Name:</label>

							<div class="col-md-8">

								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control"/> 
						<sf:errors path="name" element="em" style="color: red"/>


							</div>

						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								brand Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="Product brand" class="form-control"/> 
							<sf:errors path="brand" element="em" style="color: red"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="description">Product
								description:</label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description"
									placeholder="Product description" class="form-control"/> 
								<sf:errors path="description" element="em" style="color: red"/>
								
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Enter
								unit Price:</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice"
									placeholder="Unit price in &#8377" class="form-control"/>
								<sf:errors path="unitPrice" element="em" style="color: red"/>

							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Enter
								Quantity:</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity"
									placeholder="quantity available" class="form-control"/>
								

							</div>
						</div>
									<div class="form-group">
							<label class="control-label col-md-4" for="file">Select an
								Image:</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file"
									class="form-control"/>
								

							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select
								category:</label>
							<div class="col-md-8">
								<sf:select path="categoryId" id="categoryId" class="form-control"
								items="${categories}"
								itemLabel="name"
								itemValue="id"/>
									
								
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="submit"
									class="btn btn-primary">
							</div>
						</div>
						<sf:hidden path="id"/>
						<sf:hidden path="code"/>
						<sf:hidden path="supplierId"/>
						<sf:hidden path="active"/>
						<sf:hidden path="purchases"/>
						<sf:hidden path="views"/>

					</sf:form>

				</div>

			</div>
		</div>

	</div>

</div>

