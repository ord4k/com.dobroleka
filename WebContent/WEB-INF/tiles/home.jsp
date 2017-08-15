<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!--Parallax effect-->
<div class="parallax">
	<p class="title">
		Nad Narwią</br><span>CAŁOROCZNY DOMEK DO WYNAJĘCIA</span>
	</p>
</div>
<!--End of parallax effect-->

<!--Main_page-->
<div class="main_page">
	<p class="headers" id="zapoznaj">Zapoznaj sie z naszym miejscem</p>

	<div id=images>
		<!--Box with photos./Main page 1/2.-->
		<div id="okolica" class="image-wrapper">
			<a href="subpages/strona_okolica.html"><img class="photo"
				src="${pageContext.request.contextPath}/static/css/images/okolica/okolica_rzeka.jpg"
				alt="Okolica"><p>OKOLICA</p></a>
		</div>

		<div id="atrakcje" class="image-wrapper">
			<a href="subpages/strona_atrakcje.html"><img class="photo"
				src="${pageContext.request.contextPath}/static/css/images/atrakcje/atrakcje_rzeka.jpg"
				alt="Atrakcje"><p>ATRAKCJE</p></a>
		</div>

		<div id="pokoje" class="image-wrapper">
			<a href="subpages/strona_pokoje.html"><img class="photo"
				src="${pageContext.request.contextPath}/static/css/images/pokoje/pokoje_meble.jpg"
				alt="Pokoje"><p>POKOJE</p></a>
		</div>

	</div>
	<!--End box with photos-->
</div>
<!--End-main_page-->

<div class="parallax_2">
	<!-- Second parallax effect-->

	<div id="contact_and information">

		<!-- Two divs in contact and information-->
		<div id="contact">
			<p id="napisz">Napisz do nas!</p>
			<form id="form">
				<!-- Contact form -->
				<label for="imie">IMIĘ</label> <input type="text" id="imie"
					name="imie"> <label for="adres_mailowy">ADRES
					MAILOWY</label> <input type="text" id="adres_m" name="adres_m">
				<textarea>Twoja wiadomość...</textarea>
				<input type="submit" name="send" id="submit" value="Wyślij" />
			</form>
			<!-- End of contact form-->
		</div>

		<div id="information">
			<p>Przydane informacje</p>
			<div id="info">
				<p class="different">tel. +48 989 989 989</p>
				<p class="same">E-mail. domek@gmail.com</p>
				<p class="same">ul. Dywizjonu 303 173</p>
				<p class="same">01-770 Warszawa</p>
			</div>
		</div>
		<!-- End of two divs in contacts and information-->
	</div>

</div>
<!--End of second parallax effect-->



