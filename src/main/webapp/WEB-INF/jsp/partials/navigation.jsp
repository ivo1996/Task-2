<nav class="navbar navbar-inverse">
	<div class="container">
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a id="insertData" href="#">Home</a></li>
				<li><a id="viewData" href="#">View Data</a></li>
				<li><a id="controlPanel" href="#">Control Panel</a></li>
			</ul>
			<div style="margin-left: 35%" class="col-sm-3 col-md-3">
				<form class="navbar-form" id="searchForm">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search" name="q">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
				</form>
			</div>
			<div class="logbtn">
				<a id="btnLogin" class="btn btn-success login" href="/login" data-toggle="popover" data-placement="bottom" data-content="Please sign in!">Login</a>
			</div>
			<div class="logbtn">
				<a id="btnLogout" class="btn btn-danger logout" href="/logout">Logout</a>
			</div>
		</div>
	</div>
</nav>
<div class="container-fluid">