from user_manager import UserManager
from content_manager import ContentManager

class RecommendationSystem:
    def __init__(self):
        self.user_manager = UserManager()
        self.content_manager = ContentManager()

    def recommend(self, user_id, content_id):
        if self.user_manager.has_interaction(user_id, content_id):
            if self.user_manager.is_positive_interaction(user_id, content_id):
                return self.content_manager.get_similar_contents(content_id)
            else:
                return self.content_manager.get_different_contents(content_id)
        else:
            return self.content_manager.get_less_frequent_contents(content_id)
