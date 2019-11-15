def rotateImage(a):
    import numpy as np
    c = np.array(a)
    return np.rot90(c, 3)
