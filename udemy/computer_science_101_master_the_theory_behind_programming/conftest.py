"""
conftest.py
"""

import logging

import pytest


def pytest_configure():
    pytest.LOGGER = logging.getLogger(__name__)
