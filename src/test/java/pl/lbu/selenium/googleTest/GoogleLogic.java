package pl.lbu.selenium.googleTest;

public class GoogleLogic {

	GooglePage googlePage = new GooglePage();

	public GoogleLogic() {

	}

	public void searchTextInGoogle(String inputText) {
		googlePage.getGooglePage();
		googlePage.setInputSearch(inputText);
		googlePage.clickBtnFind();
	}

}
