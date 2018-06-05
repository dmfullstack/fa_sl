import { AppPage } from './app.po';

describe('web page app', () => {
    let page: AppPage;


    beforeEach(() => {
        page = new AppPage();
    });

    it('Favourite Page Link In Header', () => {
        page.navigatoTo();
        page.getRouterLinkMenus().get(1).getText().then(function (text) {
            expect(text).toBe('Favourite');

        });
    });

    it('Restaurant details for near by location', () => {
        page.navigatoTo();
        expect(page.getMenuText()).toContain('Welcome To My FoodieApp..............Find Your Favourite Hotels Here');
        page.getRestaurantName().get(0).getText().then(function (text) {
            expect(text).toBe('Sriracha');

        });
    });

    it('Search With City Mumbai On Button Click', () => {
        page.navigatoToSearch();
        page.getInputTextFieldCity().sendKeys('Mumbai');
        page.getSearchButton().click();
        page.getRestaurantName().get(0).getText().then(function (text) {
            expect(text).toBe('Talaiva');

        });
    });

    it('Detail Page View Where User Can Add Comments', () => {
        page.navigatoToHome();
        page.getRestaurant().get(0).click();
        expect(page.getTextArea());

    });



    it('page navigates to View page which contain heading User Reviews', () => {
        page.navigatoToHome();
        page.getRestaurant().get(0).click();
        expect(page.getHeaderText()).toContain('Restaurant Detail View');

    });



    it('page navigates to View page when click on any restaurant', () => {
        page.navigatoToHome();
        page.getRestaurant().get(0).click();


    });

it('Favourite Page Link In Header', () => {
        page.navigatoToFav();
        page.getRouterLinkMenus().get(1).getText().then(function (text) {
            expect(text).toBe('Favourite');

        });
    });

   


    it('Home Page Link In Header', () => {
        page.navigatoTo();
        page.getRouterLinkMenus().get(0).getText().then(function (text) {
            expect(text).toBe('Search');

        });
    });

});
