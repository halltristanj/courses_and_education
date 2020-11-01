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
define("super-rentals/tests/integration/components/map-test", ["qunit", "ember-qunit", "@ember/test-helpers", "super-rentals/config/environment"], function (_qunit, _emberQunit, _testHelpers, _environment) {
  "use strict";

  (0, _qunit.module)('Integration | Component | map', function (hooks) {
    (0, _emberQunit.setupRenderingTest)(hooks);
    (0, _qunit.test)('it renders a map image for the specified parameters', async function (assert) {
      await (0, _testHelpers.render)(Ember.HTMLBars.template(
      /*
        <Map
            @lat="37.7797"
            @lng="-122.4184"
            @zoom="10"
            @width="150"
            @height="120"
          />
      */
      {
        id: "hl/snceS",
        block: "{\"symbols\":[],\"statements\":[[7,\"map\",[],[[\"@lat\",\"@lng\",\"@zoom\",\"@width\",\"@height\"],[\"37.7797\",\"-122.4184\",\"10\",\"150\",\"120\"]],null]],\"hasEval\":false,\"upvars\":[]}",
        meta: {}
      }));
      assert.dom('.map').exists();
      assert.dom('.map img').hasAttribute('alt', 'Map image at coordinates 37.7797,-122.4184');
      assert.dom('.map img').hasAttribute('src', /^https:\/\/api\.mapbox\.com/, 'the src starts with "https://api.mapbox.com"');
      assert.dom('.map img').hasAttribute('width', '150');
      assert.dom('.map img').hasAttribute('height', '120');
      let {
        src
      } = (0, _testHelpers.find)('.map img');
      let token = encodeURIComponent(_environment.default.MAPBOX_TOKEN);
      assert.ok(src.includes('-122.4184,37.7797,10'), 'the src should include the lng,lat,zoom parameter');
      assert.ok(src.includes('150x120@2x'), 'the src should include the width,height and @2x parameter');
      assert.ok(src.includes(`access_token=${token}`), 'the src should include the escaped access token');
    });
    (0, _qunit.test)('it updates the `src` attribute when the arguments change', async function (assert) {
      this.setProperties({
        lat: 37.7749,
        lng: -122.4194,
        zoom: 10,
        width: 150,
        height: 120
      });
      await (0, _testHelpers.render)(Ember.HTMLBars.template(
      /*
        <Map
            @lat={{this.lat}}
            @lng={{this.lng}}
            @zoom={{this.zoom}}
            @width={{this.width}}
            @height={{this.height}}
          />
      */
      {
        id: "ivWOdoJ7",
        block: "{\"symbols\":[],\"statements\":[[7,\"map\",[],[[\"@lat\",\"@lng\",\"@zoom\",\"@width\",\"@height\"],[[27,[24,0],[\"lat\"]],[27,[24,0],[\"lng\"]],[27,[24,0],[\"zoom\"]],[27,[24,0],[\"width\"]],[27,[24,0],[\"height\"]]]],null]],\"hasEval\":false,\"upvars\":[]}",
        meta: {}
      }));
      let img = (0, _testHelpers.find)('.map img');
      assert.ok(img.src.includes('-122.4194,37.7749,10'), 'the src should include the lng,lat,zoom parameter');
      assert.ok(img.src.includes('150x120@2x'), 'the src should include the width,height and @2x parameter');
      this.setProperties({
        width: 300,
        height: 200,
        zoom: 12
      });
      assert.ok(img.src.includes('-122.4194,37.7749,12'), 'the src should include the lng,lat,zoom parameter');
      assert.ok(img.src.includes('300x200@2x'), 'the src should include the width,height and @2x parameter');
      this.setProperties({
        lat: 47.6062,
        lng: -122.3321
      });
      assert.ok(img.src.includes('-122.3321,47.6062,12'), 'the src should include the lng,lat,zoom parameter');
      assert.ok(img.src.includes('300x200@2x'), 'the src should include the width,height and @2x parameter');
    });
    (0, _qunit.test)('the default alt attribute can be overridden', async function (assert) {
      await (0, _testHelpers.render)(Ember.HTMLBars.template(
      /*
        <Map
            @lat="37.7797"
            @lng="-122.4184"
            @zoom="10"
            @width="150"
            @height="120"
            alt="A map of San Francisco"
          />
      */
      {
        id: "U35cuiTL",
        block: "{\"symbols\":[],\"statements\":[[7,\"map\",[[23,\"alt\",\"A map of San Francisco\",null]],[[\"@lat\",\"@lng\",\"@zoom\",\"@width\",\"@height\"],[\"37.7797\",\"-122.4184\",\"10\",\"150\",\"120\"]],null]],\"hasEval\":false,\"upvars\":[]}",
        meta: {}
      }));
      assert.dom('.map img').hasAttribute('alt', 'A map of San Francisco');
    });
    (0, _qunit.test)('the src, width and height attributes cannot be overridden', async function (assert) {
      await (0, _testHelpers.render)(Ember.HTMLBars.template(
      /*
        <Map
            @lat="37.7797"
            @lng="-122.4184"
            @zoom="10"
            @width="150"
            @height="120"
            src="/assets/images/teaching-tomster.png"
            width="200"
            height="300"
          />
      */
      {
        id: "4CB4PVXH",
        block: "{\"symbols\":[],\"statements\":[[7,\"map\",[[23,\"src\",\"/assets/images/teaching-tomster.png\",null],[23,\"width\",\"200\",null],[23,\"height\",\"300\",null]],[[\"@lat\",\"@lng\",\"@zoom\",\"@width\",\"@height\"],[\"37.7797\",\"-122.4184\",\"10\",\"150\",\"120\"]],null]],\"hasEval\":false,\"upvars\":[]}",
        meta: {}
      }));
      assert.dom('.map img').hasAttribute('src', /^https:\/\/api\.mapbox\.com/, 'the src starts with "https://api.mapbox.com"');
      assert.dom('.map img').hasAttribute('width', '150');
      assert.dom('.map img').hasAttribute('height', '120');
    });
  });
});
define("super-rentals/tests/integration/components/rental-test", ["qunit", "ember-qunit", "@ember/test-helpers"], function (_qunit, _emberQunit, _testHelpers) {
  "use strict";

  (0, _qunit.module)('Integration | Component | rental', function (hooks) {
    (0, _emberQunit.setupRenderingTest)(hooks);
    (0, _qunit.test)('it renders information about a rental property', async function (assert) {
      this.setProperties({
        rental: {
          title: 'Grand Old Mansion',
          owner: 'Veruca Salt',
          city: 'San Francisco',
          location: {
            lat: 37.7749,
            lng: -122.4194
          },
          category: 'Estate',
          type: 'Standalone',
          bedrooms: 15,
          image: 'https://upload.wikimedia.org/wikipedia/commons/c/cb/Crane_estate_(5).jpg',
          description: 'This grand old mansion sits on over 100 acres of rolling hills and dense redwood forests.'
        }
      });
      await (0, _testHelpers.render)(Ember.HTMLBars.template(
      /*
        <Rental @rental={{this.rental}} />
      */
      {
        id: "56rmR8vx",
        block: "{\"symbols\":[],\"statements\":[[7,\"rental\",[],[[\"@rental\"],[[27,[24,0],[\"rental\"]]]],null]],\"hasEval\":false,\"upvars\":[]}",
        meta: {}
      }));
      assert.dom('article').hasClass('rental');
      assert.dom('article h3').hasText('Grand Old Mansion');
      assert.dom('article .detail.owner').includesText('Veruca Salt');
      assert.dom('article .detail.type').includesText('Standalone');
      assert.dom('article .detail.location').includesText('San Francisco');
      assert.dom('article .detail.bedrooms').includesText('15');
      assert.dom('article .image').exists();
      assert.dom('article .map').exists();
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
