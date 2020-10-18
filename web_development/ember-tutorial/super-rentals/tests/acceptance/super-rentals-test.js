import { module, test } from 'qunit';
import { visit, currentURL } from '@ember/test-helpers';
import { setupApplicationTest } from 'ember-qunit';

module('Acceptance | super rentals', function(hooks) {
  setupApplicationTest(hooks);

  test('visiting /super-rentals', async function(assert) {
    await visit('/super-rentals');

    assert.equal(currentURL(), '/super-rentals');
  });
});
