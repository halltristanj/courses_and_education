'use strict';

define("super-rentals/tests/acceptance/super-rentals-test", ["qunit", "@ember/test-helpers", "ember-qunit"], function (_qunit, _testHelpers, _emberQunit) {
  "use strict";

  (0, _qunit.module)('Acceptance | super rentals', function (hooks) {
    (0, _emberQunit.setupApplicationTest)(hooks);
    (0, _qunit.test)('visiting /', async function (assert) {
      await (0, _testHelpers.visit)('/');
      assert.equal((0, _testHelpers.currentURL)(), '/');
      assert.dom('nav').exists();
      assert.dom('h1').hasText('SuperRentals');
      assert.dom('h2').hasText('Welcome to Super Rentals!');
      assert.dom('.jumbo a.button').hasText('About Us');
      await (0, _testHelpers.click)('.jumbo a.button');
      assert.equal((0, _testHelpers.currentURL)(), '/about');
    });
    (0, _qunit.test)('visiting /about', async function (assert) {
      await (0, _testHelpers.visit)('/about');
      assert.equal((0, _testHelpers.currentURL)(), '/about');
      assert.dom('nav').exists();
      assert.dom('h1').hasText('SuperRentals');
      assert.dom('h2').hasText('About Super Rentals');
      assert.dom('.jumbo a.button').hasText('Contact Us');
      await (0, _testHelpers.click)('.jumbo a.button');
      assert.equal((0, _testHelpers.currentURL)(), '/getting-in-touch');
    });
    (0, _qunit.test)('visiting /getting-in-touch', async function (assert) {
      await (0, _testHelpers.visit)('/getting-in-touch');
      assert.equal((0, _testHelpers.currentURL)(), '/getting-in-touch');
      assert.dom('nav').exists();
      assert.dom('h1').hasText('SuperRentals');
      assert.dom('h2').hasText('Contact Us');
      assert.dom('a.button').hasText('About');
      await (0, _testHelpers.click)('.jumbo a.button');
      assert.equal((0, _testHelpers.currentURL)(), '/about');
    });
    (0, _qunit.test)('navigating using the nav-bar', async function (assert) {
      await (0, _testHelpers.visit)('/');
      assert.dom('nav').exists();
      assert.dom('nav a.menu-index').hasText('SuperRentals');
      assert.dom('nav a.menu-about').hasText('About');
      assert.dom('nav a.menu-contact').hasText('Contact');
      await (0, _testHelpers.click)('nav a.menu-about');
      assert.equal((0, _testHelpers.currentURL)(), '/about');
      await (0, _testHelpers.click)('nav a.menu-contact');
      assert.equal((0, _testHelpers.currentURL)(), '/getting-in-touch');
      await (0, _testHelpers.click)('nav a.menu-index');
      assert.equal((0, _testHelpers.currentURL)(), '/');
    });
  });
});
define("super-rentals/tests/integration/components/jumbo-test", ["qunit", "ember-qunit", "@ember/test-helpers"], function (_qunit, _emberQunit, _testHelpers) {
  "use strict";

  (0, _qunit.module)('Integration | Component | jumbo', function (hooks) {
    (0, _emberQunit.setupRenderingTest)(hooks);
    (0, _qunit.test)('it renders the content inside a jumbo header with a tomster', async function (assert) {
      await (0, _testHelpers.render)(Ember.HTMLBars.template(
      /*
        <Jumbo>Hello World</Jumbo>
      */
      {
        id: "YfYp0FPz",
        block: "{\"symbols\":[],\"statements\":[[7,\"jumbo\",[],[[],[]],[[\"default\"],[{\"statements\":[[1,1,0,0,\"Hello World\"]],\"parameters\":[]}]]]],\"hasEval\":false,\"upvars\":[]}",
        meta: {}
      }));
      assert.dom('.jumbo').exists();
      assert.dom('.jumbo').hasText('Hello World');
      assert.dom('.jumbo .tomster').exists();
    });
  });
});
define("super-rentals/tests/integration/components/rental-test", ["qunit", "ember-qunit", "@ember/test-helpers"], function (_qunit, _emberQunit, _testHelpers) {
  "use strict";

  (0, _qunit.module)('Integration | Component | rental', function (hooks) {
    (0, _emberQunit.setupRenderingTest)(hooks);
    (0, _qunit.test)('it renders information about a rental property', async function (assert) {
      await (0, _testHelpers.render)(Ember.HTMLBars.template(
      /*
        <Rental />
      */
      {
        id: "JduD6Q+w",
        block: "{\"symbols\":[],\"statements\":[[7,\"rental\",[],[[],[]],null]],\"hasEval\":false,\"upvars\":[]}",
        meta: {}
      }));
      assert.dom('article').hasClass('rental');
      assert.dom('article h3').hasText('Grand Old Mansion');
      assert.dom('article .detail.owner').includesText('Veruca Salt');
      assert.dom('article .detail.type').includesText('Standalone');
      assert.dom('article .detail.location').includesText('San Francisco');
      assert.dom('article .detail.bedrooms').includesText('15');
      assert.dom('article .image').exists();
    });
  });
});
define("super-rentals/tests/integration/components/rental/image-test", ["qunit", "ember-qunit", "@ember/test-helpers"], function (_qunit, _emberQunit, _testHelpers) {
  "use strict";

  (0, _qunit.module)('Integration | Component | rental/image', function (hooks) {
    (0, _emberQunit.setupRenderingTest)(hooks);
    (0, _qunit.test)('it renders the given image', async function (assert) {
      await (0, _testHelpers.render)(Ember.HTMLBars.template(
      /*
        
            <Rental::Image
              src="/assets/images/teaching-tomster.png"
              alt="Teaching Tomster"
            />
          
      */
      {
        id: "QI3G9Ke4",
        block: "{\"symbols\":[],\"statements\":[[1,1,0,0,\"\\n      \"],[7,\"rental/image\",[[23,\"src\",\"/assets/images/teaching-tomster.png\",null],[23,\"alt\",\"Teaching Tomster\",null]],[[],[]],null],[1,1,0,0,\"\\n    \"]],\"hasEval\":false,\"upvars\":[]}",
        meta: {}
      }));
      assert.dom('.image').exists();
      assert.dom('.image img').hasAttribute('src', '/assets/images/teaching-tomster.png');
      assert.dom('.image img').hasAttribute('alt', 'Teaching Tomster');
    });
    (0, _qunit.test)('clicking on the component toggles its size', async function (assert) {
      await (0, _testHelpers.render)(Ember.HTMLBars.template(
      /*
        
            <Rental::Image
              src="/assets/images/teaching-tomster.png"
              alt="Teaching Tomster"
            />
          
      */
      {
        id: "QI3G9Ke4",
        block: "{\"symbols\":[],\"statements\":[[1,1,0,0,\"\\n      \"],[7,\"rental/image\",[[23,\"src\",\"/assets/images/teaching-tomster.png\",null],[23,\"alt\",\"Teaching Tomster\",null]],[[],[]],null],[1,1,0,0,\"\\n    \"]],\"hasEval\":false,\"upvars\":[]}",
        meta: {}
      }));
      assert.dom('button.image').exists();
      assert.dom('.image').doesNotHaveClass('large');
      assert.dom('.image small').hasText('View Larger');
      await (0, _testHelpers.click)('button.image');
      assert.dom('.image').hasClass('large');
      assert.dom('.image small').hasText('View Smaller');
      await (0, _testHelpers.click)('button.image');
      assert.dom('.image').doesNotHaveClass('large');
      assert.dom('.image small').hasText('View Larger');
    });
  });
});
define("super-rentals/tests/test-helper", ["super-rentals/app", "super-rentals/config/environment", "@ember/test-helpers", "ember-qunit"], function (_app, _environment, _testHelpers, _emberQunit) {
  "use strict";

  (0, _testHelpers.setApplication)(_app.default.create(_environment.default.APP));
  (0, _emberQunit.start)();
});
define('super-rentals/config/environment', [], function() {
  var prefix = 'super-rentals';
try {
  var metaName = prefix + '/config/environment';
  var rawConfig = document.querySelector('meta[name="' + metaName + '"]').getAttribute('content');
  var config = JSON.parse(decodeURIComponent(rawConfig));

  var exports = { 'default': config };

  Object.defineProperty(exports, '__esModule', { value: true });

  return exports;
}
catch(err) {
  throw new Error('Could not read config from meta tag with name "' + metaName + '".');
}

});

require('super-rentals/tests/test-helper');
EmberENV.TESTS_FILE_LOADED = true;
//# sourceMappingURL=tests.map
