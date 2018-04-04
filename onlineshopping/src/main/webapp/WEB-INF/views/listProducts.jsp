<div class="container">

	<div class="row">


		<!-- display side bar -->

		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>

		</div>

		<!-- display products -->

		<div class="col-md-9">
			<!-- Added breadcrumb component -->
			<div class="row">
				<div class="col-md-12">
				
					<c:if test="${userClickAllProducts==true}">
					
					<script>
					window.categoryId='';
					</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home </a></li>
							<li class="active">/ All products</li>
						</ol>
					</c:if>
					<c:if test="${userClickCategoryProducts==true}">
					
					<script>
					window.categoryId='${category.id}';
					</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home </a></li>
							<li><a href="${contextRoot}/show/all/products">/ All
									products </a></li>
							<li class="active">/ ${category.name}</li>
						</ol>
					</c:if>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-12">

					<table id="productListTable"
						class="table table-striped table-borderd">


						<thead>
							<tr>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
							</tr>
						</thead>
							

					</table>

				</div>

			</div>

		</div>
	</div>

</div>