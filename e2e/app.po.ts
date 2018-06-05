import { browser, by, element } from 'protractor';

export class AppPage {
    navigatoTo() {
        return browser.get('/');

    }

    navigatoToSearch() {
        return browser.get('/search');

    }

    getInputTextFieldCity() {
        return element.all(by.css('#location'));

    }

    getInputTextFieldCuisine() {
        return element.all(by.css('#cuisine'));

    }

    getSearchButton() {
        return element.all(by.css('#search-button'));
    }



    getRouterLinkMenus() {
        return element.all(by.css('div nav a'));

    }

    getRestaurantName() {
        return element.all(by.tagName('div h5'));

    }

    getMenuText() {

        return element.all(by.tagName('h1')).getText();
    }

    navigatoToHome() {
        return browser.get('/home');

    }

    getRestaurant() {
        return element.all(by.css('#search-result'));

    }

    getHeaderText() {

        return element.all(by.tagName('div h2')).getText();
    }

    getPageHeading() {

        return element.all(by.tagName('div h4')).getText();
    }
    getTextArea() {

        return element.all(by.css('#resComments'));
    }

    getUserReview() {

        return element.all(by.css('#userReview'));
    }

    saveComments() {

        return element.all(by.css('#saveComments'));
    }

    navigatoToFav() {
        return browser.get('/favourite');

    }



    

}
