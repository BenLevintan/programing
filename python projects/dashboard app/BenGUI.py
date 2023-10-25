import sys
import win32api
from PySide6.QtWidgets import QApplication, QLabel, QVBoxLayout, QPushButton, QWidget
from PySide6.QtCore import QDateTime, QTimer
from win32con import VK_MEDIA_PLAY_PAUSE, KEYEVENTF_EXTENDEDKEY, VK_VOLUME_UP, VK_VOLUME_DOWN, VK_MEDIA_NEXT_TRACK, VK_VOLUME_MUTE

# Constants
WINDOW_HEIGHT = 300
WINDOW_WIDTH_MIN = 150
WINDOW_WIDTH_EX = 180

class CounterApp(QWidget):
    def __init__(self):
        super().__init__()
        self.counter = 0
        self.init_ui()

    def init_ui(self):
        # Create layout
        self.layout = QVBoxLayout(self)
        self.time_label = QLabel(self.get_current_time())
        self.resize(WINDOW_WIDTH_MIN, WINDOW_HEIGHT)

        # Create buttons
        self.create_button('Resize window', self.toggle_size)
        self.create_button('Play/Pause', self.play_media)
        self.create_button('Volume +', self.volume_up)
        self.create_button('Volume -', self.volume_down)
        self.create_button('Next', self.next_track)
        self.create_button('Mute', self.mute_sound)

        self.layout.addWidget(self.time_label, 0)
        self.setLayout(self.layout)
        self.setMouseTracking(True)

        # Create timer for updating time label
        self.timer = QTimer(self)
        self.timer.timeout.connect(self.update_time)
        self.timer.start(1000)

    def create_button(self, text, handler):
        button = QPushButton(text)
        button.clicked.connect(handler)
        self.layout.addWidget(button)

    def mute_sound(self):
        win32api.keybd_event(VK_VOLUME_MUTE, 0)

    def toggle_size(self):
        if self.width() == WINDOW_WIDTH_MIN:
            self.resize(WINDOW_WIDTH_EX, WINDOW_HEIGHT)
        else:
            self.resize(WINDOW_WIDTH_MIN, WINDOW_HEIGHT)

    def play_media(self):
        win32api.keybd_event(VK_MEDIA_PLAY_PAUSE, 0, KEYEVENTF_EXTENDEDKEY, 0)

    def volume_up(self):
        win32api.keybd_event(VK_VOLUME_UP, 12)

    def volume_down(self):
        win32api.keybd_event(VK_VOLUME_DOWN, 12)

    def next_track(self):
        win32api.keybd_event(VK_MEDIA_NEXT_TRACK, 1)

    def get_current_time(self):
        return QDateTime.currentDateTime().toString('hh:mm:ss')

    def update_time(self):
        current_time = self.get_current_time()
        self.time_label.setText(current_time)

    def enterEvent(self, event):
        self.setWindowOpacity(1.0)
        self.resize(WINDOW_WIDTH_EX, WINDOW_HEIGHT)
        super().enterEvent(event)

    def leaveEvent(self, event):
        self.setWindowOpacity(0.3)
        self.resize(WINDOW_WIDTH_MIN, WINDOW_HEIGHT)
        super().leaveEvent(event)

if __name__ == '__main__':
    app = QApplication(sys.argv)
    window = CounterApp()
    window.show()
    sys.exit(app.exec_())

